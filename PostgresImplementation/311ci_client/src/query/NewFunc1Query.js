import React, { Component } from 'react';
import DatePicker from 'react-date-picker';
import 'react-datepicker/dist/react-datepicker.css'
import './NewAddressQuery.css';
import { changeDateFormat } from '../util/Helpers';

import { Form, Button, } from 'antd';

const FormItem = Form.Item;

class NewFunc1Query extends Component {
    constructor(props) {
        super(props);
        this.state = {
            startDate: new Date(),
            endDate: new Date()
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleStartDateChange = this.handleStartDateChange.bind(this);
        this.handleEndDateChange = this.handleEndDateChange.bind(this);
    }

    handleSubmit(event) {

        event.preventDefault();
        const queryData = {
            startDate: this.state.startDate,
            endDate: this.state.endDate
        };

        localStorage.startDay = changeDateFormat(queryData.startDate);
        localStorage.endDay = changeDateFormat(queryData.endDate);
        localStorage.queryId = 3;
        this.props.history.push('/results')
    }


    handleStartDateChange(date) {
        console.log(date);
        this.setState({
            startDate: date
        });
    }

    handleEndDateChange(date) {
        console.log(date);
        this.setState({
            endDate: date
        });
    }

    render() {

        return (
            <div className="new-query-container">
                <h2 className="page-title"> Find the total requests per type that were created within a specified time range</h2>
                <div className="new-func1-content">
                    <Form onSubmit={this.handleSubmit} className="func1-form">
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

export default NewFunc1Query;