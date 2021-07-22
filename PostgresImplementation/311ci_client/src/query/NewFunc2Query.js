import React, { Component } from 'react';
import DatePicker from 'react-date-picker';
import 'react-datepicker/dist/react-datepicker.css'
import './NewAddressQuery.css';
import { changeDateFormat } from '../util/Helpers';
import { Form, Button, Cascader} from 'antd';
import {SERVICE_TYPE_MAX_LENGTH, cascaderOptions} from "../constants";

const FormItem = Form.Item;

class NewFunc2Query extends Component {
    constructor(props) {
        super(props);
        this.state = {
            serviceType: '',
            startDate: new Date(),
            endDate: new Date()
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleStartDateChange = this.handleStartDateChange.bind(this);
        this.handleEndDateChange = this.handleEndDateChange.bind(this);
        this.handleServiceTypeChange = this.handleServiceTypeChange.bind(this);
        this.handleCascaderChange = this.handleCascaderChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const queryData = {
            requestType: this.state.serviceType,
            startDate: this.state.startDate,
            endDate: this.state.endDate
        };
        localStorage.serviceType = queryData.requestType;
        localStorage.startDay = changeDateFormat(queryData.startDate);
        localStorage.endDay = changeDateFormat(queryData.endDate);
        localStorage.queryId = 4;
        this.props.history.push('/results')
    }

    validateServiceType = (serviceType) => {
        if(serviceType.length === 0) {
            return {
                validateStatus: 'error',
                errorMsg: 'Please enter Service Type'
            }
        } else if (serviceType.length > SERVICE_TYPE_MAX_LENGTH) {
            return {
                validateStatus: 'error',
                errorMsg: `Service Type is too long (Maximum ${SERVICE_TYPE_MAX_LENGTH} characters allowed)`
            }
        } else {
            return {
                validateStatus: 'success',
                errorMsg: null
            }
        }
    }

    handleServiceTypeChange(event) {
        const value = event.target.value;
        this.setState({
            serviceType: {
                text: value,
                ...this.validateServiceType(value)
            }
        });
    }


    handleStartDateChange(date) {
        this.setState({
            startDate: date
        });
    }

    handleEndDateChange(date) {
        this.setState({
            endDate: date
        });
    }

    handleCascaderChange(type) {
        this.setState({
            serviceType: type[0]
        });
    }

    render() {

        return (
            <div className="new-query-container">
                <h2 className="page-title"> Find the total requests per day for a specific request type and time range</h2>
                <div className="new-func2-content">
                    <Form onSubmit={this.handleSubmit} className="func2-form">
                        <div className="query-form-type">
                            <Cascader className="query-form-row" options={cascaderOptions}
                                onChange={this.handleCascaderChange}
                                placeholder="Please select" />
                        </div>
                        <div className="query-form-row">
                            <label>Select start date: </label>
                            <DatePicker
                                value={this.state.startDate}
                                onChange={this.handleStartDateChange}
                                name= {"startDate"}/>
                        </div>
                        <div className="query-form-row">
                            <label>Select end date:  </label>
                            <DatePicker
                                value={this.state.endDate}
                                onChange={this.handleEndDateChange}
                                name= {"endDate"}/>
                        </div>
                        <FormItem className="query-form-row">
                            <Button type="primary" 
                                htmlType="submit" 
                                size="large"
                                className="query-form-button">Make Query</Button>
                        </FormItem>
                    </Form>
                </div>
            </div>
        );
    }
}

export default NewFunc2Query;