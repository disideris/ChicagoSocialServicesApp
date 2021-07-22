import React, { Component } from 'react';
import './NewAddressQuery.css';
import { Form, Input, Button } from 'antd';

const FormItem = Form.Item;
const { TextArea } = Input

class NewZipQuery extends Component {
    constructor(props) {
        super(props);
        this.state = {
            zipCode: {
                integer: 0
            }
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleZipCodeChange = this.handleZipCodeChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const queryData = {
            zipCode: this.state.zipCode.integer
        };
        localStorage.zipCodeInput = queryData.zipCode;
        localStorage.queryId = 2;
        this.props.history.push('/results')
    }

    validateZipCode = (zipCode) => {
        if(isNaN(zipCode)) {
            return {
                validateStatus: 'error',
                errorMsg: 'Please enter valid zip code (integer)'
            }
        } else {
            return {
                validateStatus: 'success',
                errorMsg: null
            }
        }
    }

    handleZipCodeChange(event) {
        const value = event.target.value;
        this.setState({
            zipCode: {
                integer: value,
                ...this.validateZipCode(value)
            }
        });
    }

    isFormInvalid() {
        if(this.state.zipCode.validateStatus !== 'success') {
            return true;
        }
    }

    render() {

        return (
            <div className="new-query-container">
                <h1 className="page-title">Find all incidents given a zip code</h1>
                <div className="new-zip-content">
                    <Form onSubmit={this.handleSubmit} className="zip-form">
                        <FormItem validateStatus={this.state.zipCode.validateStatus}
                                  help={this.state.zipCode.errorMsg} className="query-form-row">
                        <TextArea
                            placeholder="Enter Zip Code"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Zip Code"
                            value = {this.state.zipCode.integer}
                            onChange = {this.handleZipCodeChange} />
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

export default NewZipQuery;