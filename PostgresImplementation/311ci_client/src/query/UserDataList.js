import React, { Component } from 'react';
import {getUserQueryData, getUserInsertions} from '../util/APIUtils';
import LoadingIndicator  from '../common/LoadingIndicator';
import { Button, Icon } from 'antd';
import { QUERY_LIST_SIZE } from '../constants';
import { withRouter } from 'react-router-dom';
import './QueryList.css';
import UserQueryData from './UserQueryData';
import Incident from './Incident';

class UserDataList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userResults: [],
            page: 0,
            size: 10,
            totalElements: 0,
            totalPages: 0,
            last: true,
            isLoading: false
        };
        this.loadResultList = this.loadResultList.bind(this);
        this.handleLoadMore = this.handleLoadMore.bind(this);
    }

    loadResultList(page = 0, size = QUERY_LIST_SIZE) {
        let promise;

        if(this.props.username) {
            if(this.props.type === 'USER_QUERIES') {
                promise = getUserQueryData(this.props.username, page, size);
            } else if (this.props.type === 'USER_INCIDENT_INSERTIONS') {
                promise = getUserInsertions(this.props.username, page, size);
            }
        }

        if(!promise) {
            return;
        }

        this.setState( {
            isLoading: true
        });

        promise
        .then(response => {
            const userResults = this.state.userResults.slice();

            this.setState({
                userResults: userResults.concat(response.content),
                page: response.page,
                size: response.size,
                totalElements: response.totalElements,
                totalPages: response.totalPages,
                last: response.last,
                isLoading: false,
            })
        }).catch(error => {
            this.setState({
                isLoading: false
            })
        });

    }

    componentDidMount() {
        this.loadResultList();
    }

    componentDidUpdate(nextProps) {
        if(this.props.isAuthenticated !== nextProps.isAuthenticated) {
            // Reset State
            this.setState({
                userResults: [],
                page: 0,
                size: 10,
                totalElements: 0,
                totalPages: 0,
                last: true,
                isLoading: false
            });
            this.loadResultList();
        }
    }

    handleLoadMore() {
        this.loadResultList(this.state.page + 1);
    }

    render() {
        const userResultsViews = [];

        if(this.props.type === 'USER_QUERIES') {
            this.state.userResults.forEach((queryData) => {
                userResultsViews.push(<UserQueryData
                    key={queryData.id}
                    queryData={queryData} />)
            });
        } else if (this.props.type === 'USER_INCIDENT_INSERTIONS') {
            this.state.userResults.forEach((incident) => {
                userResultsViews.push(<Incident
                    key={incident.requestId}
                    incident={incident} />)
            });
        }




        return (
            <div className="results-container">
                {userResultsViews}
                {
                    !this.state.isLoading && this.state.userResults.length === 0 ? (
                        <div className="no-results-found">
                            <span>No Results Found!</span>
                        </div>
                    ): null
                }
                {
                    !this.state.isLoading && !this.state.last ? (
                        <div className="load-more-results">
                            <Button type="dashed" onClick={this.handleLoadMore} disabled={this.state.isLoading}>
                                <Icon type="plus" /> Load more
                            </Button>
                        </div>): null
                }
                {
                    this.state.isLoading ?
                    <LoadingIndicator />: null
                }
            </div>
        );
    }
}

export default withRouter(UserDataList);

