import React, { Component } from 'react';
import './Incident.css';
import { Avatar } from 'antd';
import {getAvatarColor} from "../util/Colors";
import { List } from 'antd';


class Func3Object extends Component {

    render() {
        return (
            <div className="incident-content">
                <div className="incident-header">
                    <div className="incident-info">
                        <div className="info-link" >
                            <Avatar className="incident-creator-avatar"
                                    style={{ backgroundColor: getAvatarColor(this.props.result[0])}} >
                            </Avatar>
                            <span className="incident-creator-requestid">
                                {this.props.result[0]}
                            </span>
                        </div>
                    </div>
                </div>
                <div className="incident-fields">
                    <List
                        className="incident-field-list-group">
                        <li>Zip code: {this.props.result[1]}</li>
                        <li>Requests: {this.props.result[2]}</li>
                    </List>
                </div>
            </div>
        );
    }
}
export default Func3Object;