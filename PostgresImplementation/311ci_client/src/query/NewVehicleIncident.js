import React, { Component } from 'react';
import DatePicker from 'react-date-picker';
import 'react-datepicker/dist/react-datepicker.css'
import { createVehicleIncident } from '../util/APIUtils';
import './NewIncident.css';
import { changeDateFormat } from '../util/Helpers';
import { Form, Input, Button, notification } from 'antd';
const FormItem = Form.Item;
const { TextArea } = Input

class NewVehicleIncident extends Component {
    constructor(props) {
        super(props);
        this.state = {
            requestNumber: '',
            requestType: 'Abandoned Vehicle Complaint',
            status: '',
            creationDate: new Date(),
            completionDate: new Date(),
            streetAddress: '',
            zipCode: 0,
            ward: 0,
            policeDistrict: 0,
            communityArea: 0,
            xCoordinate: 0.0,
            yCoordinate: 0.0,
            latitude: 0.0,
            longitude: 0.0,
            location: '',
            ssa: '',
            mostRecentAction: '',
            currentActivity: '',
            licensePlate: '',
            vehicleModel: '',
            vehicleColor: '',
            daysParked: 0.0
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleRequestNumberChange = this.handleRequestNumberChange.bind(this);
        this.handleStatusChange = this.handleStatusChange.bind(this);
        this.handleCreationDateChange = this.handleCreationDateChange.bind(this);
        this.handleCompletionDateChange = this.handleCompletionDateChange.bind(this);
        this.handleAddressChange = this.handleAddressChange.bind(this);
        this.handleZipCodeChange = this.handleZipCodeChange.bind(this);
        this.handleWardChange = this.handleWardChange.bind(this);
        this.handlePoliceDistrictChange = this.handlePoliceDistrictChange.bind(this);
        this.handleCommunityAreaChange = this.handleCommunityAreaChange.bind(this);
        this.handleXCoordinateChange = this.handleXCoordinateChange.bind(this);
        this.handleYCoordinateChange = this.handleYCoordinateChange.bind(this);
        this.handleLatitudeChange = this.handleLatitudeChange.bind(this);
        this.handleLongitudeChange = this.handleLongitudeChange.bind(this);
        this.handleLocationChange = this.handleLocationChange.bind(this);
        this.handleSsaChange = this.handleSsaChange.bind(this);
        this.handleMostRecentActionChange = this.handleMostRecentActionChange.bind(this);
        this.handleCurrentAcitivityChange = this.handleCurrentAcitivityChange.bind(this);
        this.handlePlateChange = this.handlePlateChange.bind(this);
        this.handleModelChange = this.handleModelChange.bind(this);
        this.handleColorChange = this.handleColorChange.bind(this);
        this.handleDaysParkedChange = this.handleDaysParkedChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const incidentData = {
            requestNumber: this.state.requestNumber.text,
            requestType: this.state.requestType,
            status: this.state.status.text,
            creationDate: changeDateFormat(this.state.creationDate),
            completionDate: changeDateFormat(this.state.completionDate),
            streetAddress: this.state.streetAddress.text,
            zipCode: this.state.zipCode.integer,
            ward: this.state.ward.integer,
            policeDistrict: this.state.policeDistrict.integer,
            communityArea: this.state.communityArea.integer,
            xCoordinate: this.state.xCoordinate.float,
            yCoordinate: this.state.yCoordinate.float,
            latitude: this.state.latitude.float,
            longitude: this.state.longitude.float,
            location: this.state.location.text,
            ssa: this.state.ssa.text,
            mostRecentAction: this.state.mostRecentAction.text,
            currentActivity: this.state.currentActivity.text,
            licensePlate: this.state.licensePlate.text,
            vehicleModel: this.state.vehicleModel.text,
            vehicleColor: this.state.vehicleColor.text,
            daysParked: this.state.daysParked.float
        };

        createVehicleIncident(incidentData)
        .then(response => {
            this.props.history.push("/");
        }).catch(error => {
            if(error.status === 401) {
                this.props.handleLogout('/login', 'error', 'You have been logged out. Please login to create incident.');
            } else {
                notification.error({
                    message: '311CI Service',
                    description: error.message || 'Sorry! Something went wrong. Please try again!'
                });
            }
        });
    }

    handleRequestNumberChange(event) {
        const value = event.target.value;
        this.setState({
            requestNumber: {
                text: value,
            }
        });
    }

    handleStatusChange(event) {
        const value = event.target.value;
        this.setState({
            status: {
                text: value,
            }
        });
    }

    handleCreationDateChange(date) {
        this.setState({
            creationDate: date
        });
    }

    handleCompletionDateChange(date) {
        this.setState({
            completionDate: date
        });
    }

    handleAddressChange(event) {
        const value = event.target.value;
        this.setState({
            streetAddress: {
                text: value,
            }
        });
    }

    handleZipCodeChange(event) {
        const value = event.target.value;
        this.setState({
            zipCode: {
                integer: value,
            }
        });
    }

    handleWardChange(event) {
        const value = event.target.value;
        this.setState({
            ward: {
                integer: value,
            }
        });
    }

    handlePoliceDistrictChange(event) {
        const value = event.target.value;
        this.setState({
            policeDistrict: {
                integer: value,
            }
        });
    }

    handleCommunityAreaChange(event) {
        const value = event.target.value;
        this.setState({
            communityArea: {
                integer: value,
            }
        });
    }

    handleXCoordinateChange(event) {
        const value = event.target.value;
        this.setState({
            xCoordinate: {
                float: value,
            }
        });
    }


    handleYCoordinateChange(event) {
        const value = event.target.value;
        this.setState({
            yCoordinate: {
                float: value,
            }
        });
    }

    handleLatitudeChange(event) {
        const value = event.target.value;
        this.setState({
            latitude: {
                float: value,
            }
        });
    }

    handleLongitudeChange(event) {
        const value = event.target.value;
        this.setState({
            longitude: {
                float: value,
            }
        });
    }

    handleLocationChange(event) {
        const value = event.target.value;
        this.setState({
            location: {
                text: value,
            }
        });
    }

    handleSsaChange(event) {
        const value = event.target.value;
        this.setState({
            ssa: {
                text: value,
            }
        });
    }

    handleMostRecentActionChange(event) {
        const value = event.target.value;
        this.setState({
            mostRecentAction: {
                text: value,
            }
        });
    }

    handleCurrentAcitivityChange(event) {
        const value = event.target.value;
        this.setState({
            currentActivity: {
                text: value,
            }
        });
    }

    handlePlateChange(event) {
        const value = event.target.value;
        this.setState({
            licensePlate: {
                text: value,
            }
        });
    }

    handleModelChange(event) {
        const value = event.target.value;
        this.setState({
            vehicleModel: {
                text: value,
            }
        });
    }

    handleColorChange(event) {
        const value = event.target.value;
        this.setState({
            vehicleColor: {
                text: value,
            }
        });
    }

    handleDaysParkedChange(event) {
        const value = event.target.value;
        this.setState({
            daysParked: {
                float: value,
            }
        });
    }

    render() {

        return (

            <div className="new-incident-container">

                <div className="new-incident-content">
                    <Form onSubmit={this.handleSubmit} className="create-incident-form">
                        <div className="incident-form-row">
                            <label>Select Creation date: </label>
                            <DatePicker
                                value={this.state.creationDate}
                                onChange={this.handleCreationDateChange}
                                name= {"creation date"}/>
                        </div>
                        <div className="incident-form-row">
                            <label>Select Completion date: </label>
                            <DatePicker
                                value={this.state.completionDate}
                                onChange={this.handleCompletionDateChange}
                                name= {"completion Date"}/>
                        </div>
                        <FormItem validateStatus={this.state.requestNumber.validateStatus}
                                  help={this.state.requestNumber.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Service Request Number"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Service Request Number"
                            value = {this.state.requestNumber.text}
                            onChange = {this.handleRequestNumberChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.status.validateStatus}
                                  help={this.state.status.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Status"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Status"
                            value = {this.state.status.text}
                            onChange = {this.handleStatusChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.streetAddress.validateStatus}
                            help={this.state.streetAddress.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Street Address"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Street Address"
                            value = {this.state.streetAddress.text}
                            onChange = {this.handleAddressChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.zipCode.validateStatus}
                            help={this.state.zipCode.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Zip Code"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Zip Code"
                            value = {this.state.zipCode.integer}
                            onChange = {this.handleZipCodeChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.ward.validateStatus}
                            help={this.state.ward.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Ward"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Ward"
                            value = {this.state.ward.integer}
                            onChange = {this.handleWardChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.policeDistrict.validateStatus}
                                  help={this.state.policeDistrict.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Police District"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Police District"
                            value = {this.state.policeDistrict.integer}
                            onChange = {this.handlePoliceDistrictChange}/>
                        </FormItem>
                        <FormItem validateStatus={this.state.communityArea.validateStatus}
                            help={this.state.communityArea.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Community Area"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Community Area"
                            value = {this.state.communityArea.integer}
                            onChange = {this.handleCommunityAreaChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.xCoordinate.validateStatus}
                            help={this.state.xCoordinate.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter x Coordinate"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "x Coordinate"
                            value = {this.state.xCoordinate.float}
                            onChange = {this.handleXCoordinateChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.yCoordinate.validateStatus}
                            help={this.state.yCoordinate.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter y Coordinate"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "y Coordinate"
                            value = {this.state.yCoordinate.float}
                            onChange = {this.handleYCoordinateChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.latitude.validateStatus}
                            help={this.state.latitude.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Latitude"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Latitude"
                            value = {this.state.latitude.float}
                            onChange = {this.handleLatitudeChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.longitude.validateStatus}
                            help={this.state.longitude.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Longitude"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Longitude"
                            value = {this.state.longitude.float}
                            onChange = {this.handleLongitudeChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.location.validateStatus}
                            help={this.state.location.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Location"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Location"
                            value = {this.state.location.text}
                            onChange = {this.handleLocationChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.ssa.validateStatus}
                            help={this.state.ssa.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter SSA"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "SSA"
                            value = {this.state.ssa.text}
                            onChange = {this.handleSsaChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.mostRecentAction.validateStatus}
                            help={this.state.mostRecentAction.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Most Recent Action"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Most Recent Action"
                            value = {this.state.mostRecentAction.text}
                            onChange = {this.handleMostRecentActionChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.currentActivity.validateStatus}
                            help={this.state.currentActivity.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Current Activity"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Current Activity "
                            value = {this.state.currentActivity.text}
                            onChange = {this.handleCurrentAcitivityChange} />
                        </FormItem>
                        <FormItem validateStatus={this.state.licensePlate.validateStatus}
                                  help={this.state.licensePlate.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Vehicle's License Plate"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "License Plate"
                            value = {this.state.licensePlate.text}
                            onChange = {this.handlePlateChange}/>
                        </FormItem>
                        <FormItem validateStatus={this.state.vehicleModel.validateStatus}
                                  help={this.state.vehicleModel.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Vehicle's Model"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Vehicle Model"
                            value = {this.state.vehicleModel.text}
                            onChange = {this.handleModelChange}/>
                        </FormItem>
                        <FormItem validateStatus={this.state.vehicleColor.validateStatus}
                                  help={this.state.vehicleColor.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Vehicle's Color"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Vehicle Color"
                            value = {this.state.vehicleColor.text}
                            onChange = {this.handleColorChange}/>
                        </FormItem>
                        <FormItem validateStatus={this.state.daysParked.validateStatus}
                                  help={this.state.daysParked.errorMsg} className="incident-form-row">
                        <TextArea
                            placeholder="Enter Days the vehicle is parked"
                            style = {{ fontSize: '16px' }}
                            autosize={{maxRows: 1 }}
                            name = "Days Parked"
                            value = {this.state.daysParked.float}
                            onChange = {this.handleDaysParkedChange}/>
                        </FormItem>
                        <FormItem className="incident-form-row">
                            <Button type="primary"
                                htmlType="submit"
                                size="large"
                                className="create-incident-form-button">Create Incident</Button>
                        </FormItem>
                    </Form>
                </div>
            </div>
        );
    }
}




export default NewVehicleIncident;
