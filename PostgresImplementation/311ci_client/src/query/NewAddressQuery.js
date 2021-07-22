import React, { Component } from 'react';
import './NewAddressQuery.css';
import { Form, Input, Button} from 'antd';
import {INCIDENT_ADDRESS_MAX_LENGTH,} from "../constants";
const FormItem = Form.Item;
const { TextArea } = Input

class NewAddressQuery extends Component {
    constructor(props) {
        super(props);
        this.state = {
            streetAddress: {
                text: ''
            }
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleAddressChange = this.handleAddressChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const queryData = {
            streetAddress: this.state.streetAddress.text
        };
        localStorage.addressInput = queryData.streetAddress;
        localStorage.queryId = 1;
        this.props.history.push('/results')
    }

    validateAddress = (addressText) => {
        if(addressText.length === 0) {
            return {
                validateStatus: 'error',
                errorMsg: 'Please enter Street Address'
            }
        } else if (addressText.length > INCIDENT_ADDRESS_MAX_LENGTH) {
            return {
                validateStatus: 'error',
                errorMsg: `Address is too long (Maximum ${INCIDENT_ADDRESS_MAX_LENGTH} characters allowed)`
            }
        } else {
            return {
                validateStatus: 'success',
                errorMsg: null
            }
        }
    }

    handleAddressChange(event) {
        const value = event.target.value;
        this.setState({
            streetAddress: {
                text: value,
                ...this.validateAddress(value)
            }
        });
    }

    isFormInvalid() {
        if(this.state.streetAddress.validateStatus !== 'success') {
            return true;
        }
    }

    render() {

        return (
            <div className="new-query-container">
                <h1 className="page-title">Find all incidents given a street address</h1>
                <div className="new-address-content">
                    <Form onSubmit={this.handleSubmit} className="address-form">
                        <FormItem validateStatus={this.state.streetAddress.validateStatus}
                            help={this.state.streetAddress.errorMsg} className="query-form-row">
                        <TextArea 
                            placeholder="Enter Street Address"
                            style = {{ fontSize: '16px' }} 
                            autosize={{maxRows: 1 }}
                            name = "Street Address"
                            value = {this.state.streetAddress.text}
                            onChange = {this.handleAddressChange} />
                        </FormItem>
                        <FormItem className="query-form-row">
                            <Button type="primary" 
                                htmlType="submit" 
                                size="large"
                                disabled={this.isFormInvalid()}
                                className="query-form-button">Make Query</Button>
                        </FormItem>
                    </Form>
                </div>    
            </div>
        );
    }
}




export default NewAddressQuery;