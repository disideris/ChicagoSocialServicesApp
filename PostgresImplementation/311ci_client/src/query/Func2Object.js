import React, { Component } from 'react';
import './Incident.css';
import { Avatar } from 'antd';
import {getAvatarColorByDate} from "../util/Colors";
import { List } from 'antd';
import {formatDateTime} from "../util/Helpers";


class Func2Object extends Component {

    render() {
        return (
            <div className="incident-content">
                <div className="incident-header">
                    <div className="incident-info">
                        <div className="info-link" >
                            <Avatar className="incident-creator-avatar"
                                    style={{ backgroundColor: getAvatarColorByDate(formatDateTime(this.props.result[0]))}} >
                            </Avatar>
                            <span className="incident-creator-requestid">
                               {formatDateTime(this.props.result[0])}
                            </span>
                        </div>
                    </div>
                </div>
                <div className="incident-fields">
                    <List
                        className="incident-field-list-group">
                        <li>Requests: {this.props.result[1]}</li>
                    </List>
                </div>
            </div>
        );
    }
}
export default Func2Object;