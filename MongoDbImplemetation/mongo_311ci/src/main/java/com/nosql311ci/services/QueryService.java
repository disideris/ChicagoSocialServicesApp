package com.nosql311ci.services;

import com.mongodb.BasicDBObject;
import com.nosql311ci.models.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.data.mongodb.core.aggregation.DateOperators.*;

@Service
public class QueryService {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Object> getResultsFromQuery1(String startDate, String endDate) {

        Aggregation agg = newAggregation(
                match(Criteria.where("creation_date").gt(startDate).lt(endDate)),
                group("service_request_type").count().as("total"),
                project("total").and("service_request_type").previousOperation(),
                sort(Sort.Direction.DESC, "total")

        );

        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "incidents", Object.class);

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery2(String requestType, String startDate, String endDate)  {

        Aggregation agg = newAggregation(
                match(Criteria.where("creation_date").gt(startDate).lt(endDate).and("service_request_type").is(requestType)),
                group("creation_date").count().as("total"),
                project("total").and("creation_date").previousOperation(),
                sort(Sort.Direction.DESC, "total")

        );

        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "incidents", Object.class);

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery3(String someDay) {

        Aggregation agg = newAggregation(
                match(Criteria.where("creation_date").is(someDay)),
                group("zip_code", "service_request_type").count().as("count"),
                sort(Sort.Direction.DESC, "count"),
                project("count").and("group1").previousOperation(),
                group("group1.zip_code").push(new BasicDBObject("service_request_type", "$group1.service_request_type")
                                            .append("count2", "$count" ))
                                            .as("typefreqs"),
                project().andExpression("_id").as("zip_code").andExclude("_id").andExpression("typefreqs").slice(3)
        );


        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "incidents", Object.class);

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery4(String requestType) {

        Aggregation agg = newAggregation(
                match(Criteria.where("service_request_type").is(requestType)),
                group("ward").count().as("total"),
                project("total").and("ward").previousOperation(),
                sort(Sort.Direction.ASC, "total"),
                limit(3)

        );

        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "incidents", Object.class);

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery5(String startDate, String endDate) {

        Aggregation agg = newAggregation(
                match(Criteria.where("creation_date").gte(startDate).lte(endDate).and("status").regex("Completed")),
                group("service_request_type").count().as("count")
                                                .avg(ArithmeticOperators.Divide.valueOf(
                                                        ArithmeticOperators.Subtract.valueOf(DateFromString.fromStringOf("completion_date"))
                                                        .subtract( DateFromString.fromStringOf("creation_date"))
                                                ).divideBy(1000 * 3600 * 24)).as("avgTime"),
                project().andExpression("_id").as("serviceRequestType").and("avgTime").as("Average Time in Days").andExclude("_id"),
                sort(Sort.Direction.DESC, "Average Time in Days")
        );
        AggregationResults<Object> groupResults = mongoTemplate.aggregate(agg, "incidents", Object.class);

        return groupResults.getMappedResults();
    }

    public List<Object> getResultsFromQuery6(double lat1, double lon1, double lat2, double lon2) {

        Aggregation agg = newAggregation(
                match(Criteria.where("latitude").gt(lat1).lt(lat2).and("longitude").gt(lon1).lt(lon2)),
                //match(Criteria.where("longitude").lt(lon1).lt(lon2)),
                group("service_request_type").count().as("total"),
                project("total").and("service_request_type").previousOperation(),
                sort(Sort.Direction.DESC, "total"),
                limit(1)
        );


        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "incidents2", Object.class);

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery7(String someDay) {

        Aggregation agg = newAggregation(
                unwind("upvotes"),
                match(Criteria.where("upvotes.creation_date").is(someDay)),
                group("upvotes.service_request_number").count().as("total"),
                project("total"),
                sort(Sort.Direction.DESC, "total"),
                limit(50)
        );

        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "citizens", Object.class);

        for (Object o : result) {
            System.out.println(o);
        }

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery8() {

        Aggregation agg = newAggregation(
                match(Criteria.where("upvotes").type(4)),
                project("name").andExpression("upvotes").size().as("votesize").andExclude("_id"),
                sort(Sort.Direction.DESC, "votesize"),
                limit(50)
        );

        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "citizens", Object.class);

        return result.getMappedResults();
    }

    public List<Query9Result> getResultsFromQuery9() {

        Aggregation agg = newAggregation(
                unwind("upvotes"),
                project("_id", "name", "upvotes.ward"),
                group("_id").addToSet("ward").as("ward"),
                project("_id").and("ward").size().as("distinctWards"),
                sort(Sort.Direction.DESC, "distinctWards"),
                limit(50)
        ).withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());


        AggregationResults<Query9Result> result = mongoTemplate.aggregate(agg, "citizens", Query9Result.class);

        return result.getMappedResults();
    }

    public List<Query10Result> getResultsFromQuery10() {

        Aggregation agg = newAggregation(
                unwind("upvotes"),
                group("phone").addToSet("name").as("citizen").addToSet("upvotes._id").as("incident_ids"),
                project("incident_ids").and("citizen").size().as("cit_size").and("phone").previousOperation(),
                match(Criteria.where("cit_size").gte(2)),
                project("incident_ids", "phone")
        ).withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());


        AggregationResults<Query10Result> result = mongoTemplate.aggregate(agg, "citizens", Query10Result.class);

        return result.getMappedResults();
    }

    public List<Object> getResultsFromQuery11(String name) {

        Aggregation agg = newAggregation(
                match(Criteria.where("name").is(name)),
                unwind("upvotes"),
                group("name").addToSet("upvotes.ward").as("wards"),
                project().and("name").previousOperation().and("wards").as("Wards")
        );

        AggregationResults<Object> result = mongoTemplate.aggregate(agg, "citizens", Object.class);

        return result.getMappedResults();
    }

    public List<Citizen> getCitizensByVotedIncident(String incidentId) {

        ObjectId objectid = new ObjectId(incidentId);
        Aggregation agg = newAggregation(
                match(Criteria.where("upvotes._id").is(objectid))
        ).withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());

        AggregationResults<Citizen> result = mongoTemplate.aggregate(agg, "citizens", Citizen.class);

        return result.getMappedResults();
    }
}
