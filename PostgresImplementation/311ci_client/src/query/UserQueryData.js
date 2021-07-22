import React, { Component } from 'react';
import './UserQueryData.css';
import { Avatar} from 'antd';
import { formatDateTime2 } from '../util/Helpers';
import { getAvatarColor } from "../util/Colors";

import { List } from 'antd';

class UserQueryData extends Component {

    render() {
        return (
            <div className="user-query-data-content">
                <div className="user-query-data-header">
                    <div className="user-query-data-info">
                        <div className="info-link" >
                            <Avatar className="user-query-data-creator-avatar"
                                style={{ backgroundColor: getAvatarColor(this.props.queryData.username)}}>
                                {this.props.queryData.username[0].toUpperCase()}
                            </Avatar>
                            <span className="user-query-data-creator-requestnumber">
                                Query issued at: {formatDateTime2(this.props.queryData.createdAt)}
                            </span>
                        </div>
                    </div>
                </div>
                <div className="user-query-data-fields">
                    <List
                        className="user-query-data-field-list-group">
                        <li>Query: {this.props.queryData.userQuery}</li>
                    </List>
                </div>
            </div>
        );
    }
}
export default UserQueryData;