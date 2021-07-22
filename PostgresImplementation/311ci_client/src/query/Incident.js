import React, { Component } from 'react';
import './Incident.css';
import { Avatar} from 'antd';
import { formatDateTime, formatDateTime2 } from '../util/Helpers';
import {getAvatarStatusColor} from "../util/Colors";

import { List } from 'antd';

class Incident extends Component {

    render() {
        return (
            <div className="incident-content">
                <div className="incident-header">
                    <div className="incident-info">
                        <div className="info-link" >
                            <Avatar className="incident-creator-avatar"
                                    style={{ backgroundColor: getAvatarStatusColor(this.props.incident.status)}} >
                                {this.props.incident.status}
                            </Avatar>
                            <span className="incident-creator-requestid">
                                Request id: {this.props.incident.requestId}
                            </span>
                            <span className="incident-creation-date">
                                Incident inserted at: {formatDateTime2(this.props.incident.createdAt)}
                            </span>
                        </div>
                    </div>
                    <div className="incident-type">
                        Request Type: {this.props.incident.serviceRequestType}
                    </div>
                </div>
                <div className="incident-fields">
                    <List
                        className="incident-field-list-group">
                        <li>Request Number: {this.props.incident.serviceRequestNumber}</li>
                        <li>Address: {this.props.incident.streetAddress}</li>
                        <li>Creation date: {formatDateTime(this.props.incident.creationDate)}</li>
                        <li>Completion date: {formatDateTime(this.props.incident.completionDate)}</li>
                        <li>Zip: {this.props.incident.zipCode}</li>
                        <li>Ward: {this.props.incident.ward}</li>
                        <li>Police district: {this.props.incident.policeDistrict}</li>
                        <li>Community Area: {this.props.incident.communityArea}</li>
                        <li>xcoordinate: {this.props.incident.xCoordinate}</li>
                        <li>ycoordinate: {this.props.incident.yCoordinate}</li>
                        <li>latitude: {this.props.incident.latitude}</li>
                        <li>longitude: {this.props.incident.longitude}</li>
                        <li>location: {this.props.incident.location}</li>
                    </List>
                </div>
            </div>
        );
    }
}
export default Incident;