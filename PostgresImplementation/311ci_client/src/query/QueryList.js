import React, { Component } from 'react';
import { getIncidentsByAddress, getIncidentsByZip, getFunc1Results, getFunc2Results, getFunc3Results } from '../util/APIUtils';
import Incident from './Incident';
import LoadingIndicator  from '../common/LoadingIndicator';
import { Button, Icon } from 'antd';
import { QUERY_LIST_SIZE } from '../constants';
import { withRouter } from 'react-router-dom';
import './QueryList.css';
import Func1Object from "./Func1Object";
import Func2Object from "./Func2Object";
import Func3Object from "./Func3Object"

class QueryList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            results: [],
            page: 0,
            size: 10,
            totalElements: 0,
            totalPages: 0,
            last: true,
            isLoading: false,
        };
        this.loadResultList = this.loadResultList.bind(this);
        this.handleLoadMore = this.handleLoadMore.bind(this);
    }

    loadResultList(page = 0, size = QUERY_LIST_SIZE) {
        let promise;
        if(localStorage.queryId == 1) {
            promise = getIncidentsByAddress(page, size, localStorage.addressInput);
            console.log("=============== page ============> "+page)
        } else if(localStorage.queryId == 2) {
            promise = getIncidentsByZip(page, size, localStorage.zipCodeInput);
        } else if(localStorage.queryId == 3) {
           promise = getFunc1Results(page, size, localStorage.startDay, localStorage.endDay);
            //window.localStorage.removeItem("queryId");
        } else if(localStorage.queryId == 4) {
            promise = getFunc2Results(page, size, localStorage.serviceType, localStorage.startDay, localStorage.endDay);
        } else if (localStorage.queryId == 5) {
            promise = getFunc3Results(page, size, localStorage.someDate);
        }

        if(!promise) {
            return;
        }

        this.setState( {
            isLoading: true
        });

        promise
        .then(response => {
            const results = this.state.results.slice();

            this.setState({
                results: results.concat(response.content),
                page: response.page,
                size: response.size,
                totalElements: response.totalElements,
                totalPages: response.totalPages,
                last: response.last,
                isLoading: false,
            })
        }).catch(error => {
            this.setState({
                isLoading: false
            })
        });
    }

    componentDidMount() {
        this.loadResultList();
    }

    componentDidUpdate(nextProps) {
        if(this.props.isAuthenticated !== nextProps.isAuthenticated) {
            // Reset State
            this.setState({
                results: [],
                page: 0,
                size: 10,
                totalElements: 0,
                totalPages: 0,
                last: true,
                isLoading: false
            });
            this.loadResultList();
        }
    }

    handleLoadMore() {
        this.loadResultList(this.state.page + 1);
    }

    render() {
        const resultsViews = [];
        if (localStorage.queryId < 3) {
            this.state.results.forEach((incident, resIndex) => {
                resultsViews.push(<Incident
                    key={incident}
                    incident={incident} />)
            });

        } else if (localStorage.queryId  == 3) {
            this.state.results.forEach((result) => {
                resultsViews.push(<Func1Object
                    key={result[0]}
                    result={result} />)
            });
        } else if (localStorage.queryId  == 4) {
            this.state.results.forEach((result) => {
                resultsViews.push(<Func2Object
                    key={result[0]}
                    result={result} />)
            });
        } else if (localStorage.queryId  == 5) {
            this.state.results.forEach((result) => {
                resultsViews.push(<Func3Object
                    key={result[1]}
                    result={result} />)
            });
        }


        return (
            <div className="results-container">
                {resultsViews}
                {
                    !this.state.isLoading && this.state.results.length === 0 ? (
                        <div className="no-results-found">
                            <span>No results Found!</span>
                        </div>
                    ): null
                }
                {
                    !this.state.isLoading && !this.state.last ? (
                        <div className="load-more-results">
                            <Button type="dashed" onClick={this.handleLoadMore} disabled={this.state.isLoading}>
                                <Icon type="plus" /> Load more
                            </Button>
                        </div>): null
                }
                {
                    this.state.isLoading ?
                    <LoadingIndicator />: null
                }
            </div>
        );
    }
}

export default withRouter(QueryList);
