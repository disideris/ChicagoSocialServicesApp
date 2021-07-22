import React, { Component } from 'react';
import DatePicker from 'react-date-picker';
import 'react-datepicker/dist/react-datepicker.css'
import './NewAddressQuery.css';
import { changeDateFormat } from '../util/Helpers';
import { Form, Button, } from 'antd';

const FormItem = Form.Item;

class NewFunc3Query extends Component {
    constructor(props) {
        super(props);
        this.state = {
            someDate: new Date()
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleSomeDateChange = this.handleSomeDateChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const queryData = {
            someDay: this.state.someDate
        };
        localStorage.someDate = changeDateFormat(queryData.someDay);
        localStorage.queryId = 5;
        this.props.history.push('/results')
    }


    handleSomeDateChange(date) {
        console.log(date);
        this.setState({
            someDate: date
        });
    }


    render() {

        return (
            <div className="new-query-container">
                <h2 className="page-title">Find the most common service request per zipcode for a specific day</h2>
                <div className="new-func1-content">
                    <Form onSubmit={this.handleSubmit} className="func1-form">
                        <div className="query-form-row">
                            <label>Select a day: </label>
                            <DatePicker
                                value={this.state.someDate}
                                onChange={this.handleSomeDateChange}
                                name= {"someDate"}/>
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

export default NewFunc3Query;