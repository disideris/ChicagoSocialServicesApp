import React, { Component } from 'react';
import {
    Link,
    withRouter
} from 'react-router-dom';
import './AppHeader.css';
import insertIcon from '../insertdb.png';
import queryIcon from '../query.png';
import resultIcon from '../results-icon.png';
import { Layout, Menu, Dropdown, Icon } from 'antd';
const Header = Layout.Header;

class AppHeader extends Component {
    constructor(props) {
        super(props);
        this.handleMenuClick = this.handleMenuClick.bind(this);
    }

    handleMenuClick({ key }) {
        if(key === "logout") {
            this.props.onLogout();
        }
    }

    render() {
        let menuItems;
        if(this.props.currentUser) {
          menuItems = [
            <Menu.Item key="/">
              <Link to="/">
                <Icon type="home" className="nav-icon" />
              </Link>
            </Menu.Item>,
            <Menu.Item key="/results">
            <Link to="/results">
              <img src={resultIcon} alt="result" className="result-icon" />
            </Link>
          </Menu.Item>,
          <Menu.Item key="/incident/new" className-="newincident-menu">
              <NewIncidentDropdownMenu
                  currentUser={this.props.currentUser}
                  handleMenuClick={handleLightType}/>
          </Menu.Item>,
          <Menu.Item key="/query" className="query-menu">
            <QueryDropdownMenu
                currentUser={this.props.currentUser}/>
          </Menu.Item>,
          <Menu.Item key="/profile" className="profile-menu">
            <ProfileDropdownMenu
                currentUser={this.props.currentUser}
                handleMenuClick={this.handleMenuClick}/>
            </Menu.Item>
          ];
        } else {
          menuItems = [
            <Menu.Item key="/login">
              <Link to="/login">Login</Link>
            </Menu.Item>,
            <Menu.Item key="/signup">
              <Link to="/signup">Signup</Link>
            </Menu.Item>
          ];
        }

        return (
            <Header className="app-header">
            <div className="container">
              <div className="app-title" >
                <Link to="/">311CI Service</Link>
              </div>
              <Menu
                className="app-menu"
                mode="horizontal"
                selectedKeys={[this.props.location.pathname]}
                style={{ lineHeight: '64px' }} >
                  {menuItems}
              </Menu>
            </div>
          </Header>
        );
    }
}

function ProfileDropdownMenu(props) {
    const dropdownMenu = (
        <Menu onClick={props.handleMenuClick} className="profile-dropdown-menu">
            <Menu.Item key="user-info" className="dropdown-item" disabled>
                <div className="user-full-name-info">
                    {props.currentUser.name}
                </div>
                <div className="username-info">
                    @{props.currentUser.username}
                </div>
            </Menu.Item>
            <Menu.Divider />
            <Menu.Item key="profile" className="dropdown-item">
                <Link to={`/users/${props.currentUser.username}`}>Profile</Link>
            </Menu.Item>
            <Menu.Item key="logout" className="dropdown-item">
                Logout
            </Menu.Item>
        </Menu>
    );

    return (
        <Dropdown
            overlay={dropdownMenu}
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
            <a className="ant-dropdown-link">
                <Icon type="user" className="nav-icon" style={{marginRight: 0}} /> <Icon type="down" />
            </a>
        </Dropdown>
    );
}

function NewIncidentDropdownMenu() {
    const dropdownMenu = (
        <Menu onClick={handleLightType} className="profile-dropdown-menu">
            <Menu.Item key="user-info" className="dropdown-item" disabled>
                <div className="user-full-name-info">
                    Create new Incident
                </div>
            </Menu.Item>
            <Menu.Divider />
            <Menu.Item key="newGraffitiIncident" className="dropdown-item">
                <Link to={`/newGraffitiIncident`}>Graffiti Inicent</Link>
            </Menu.Item>
            <Menu.Item key="newGarbageCartIncident" className="dropdown-item">
                <Link to={`/newGarbageCartIncident`}>Garbage Cart Inicent</Link>
            </Menu.Item>
            <Menu.Item key="newPotholeIncident" className="dropdown-item">
                <Link to={`/newPotholeIncident`}>Pothole Incident</Link>
            </Menu.Item>
            <Menu.Item key="newRodentIncident" className="dropdown-item">
                <Link to={`/newRodentIncident`}>Rodent Incident</Link>
            </Menu.Item>
            <Menu.Item key="newSanitationIncident" className="dropdown-item">
                <Link to={`/newSanitationIncident`}>Sanitation Incident</Link>
            </Menu.Item>
            <Menu.Item key="newTreeDebrisIncident" className="dropdown-item">
                <Link to={`/newTreeDebrisIncident`}>Tree Debris Incident</Link>
            </Menu.Item>
            <Menu.Item key="newTreeTrimsIncident" className="dropdown-item">
                <Link to={`/newTreeTrimsIncident`}>Tree Trims Incident</Link>
            </Menu.Item>
            <Menu.Item key="newVehicleIncident" className="dropdown-item">
                <Link to={`/newVehicleIncident`}>Vehicle Incident</Link>
            </Menu.Item>
            <Menu.Item key="newAlleyLightIncident" className="dropdown-item">
                <Link to={`/newGenericIncident`}>Alley Light Incident</Link>
            </Menu.Item>
            <Menu.Item key="newStreetLightAllIncident" className="dropdown-item">
                <Link to={`/newGenericIncident`}>Street Light All Incident</Link>
            </Menu.Item>
            <Menu.Item key="newStreetLightOneIncident" className="dropdown-item">
                <Link to={`/newGenericIncident`}>Street Light One Incident</Link>
            </Menu.Item>
        </Menu>
    );

    return (
        <Dropdown
            overlay={dropdownMenu}
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
            <a className="ant-dropdown-link">
                <img src={insertIcon} alt="insert" className="insert-icon" />
            </a>
        </Dropdown>
    );
}

function QueryDropdownMenu(props) {
    const dropdownMenu = (
        <Menu className="profile-dropdown-menu">
            <Menu.Item key="user-info" className="dropdown-item" disabled>
                <div className="user-full-name-info">
                    311CI Queries
                </div>
            </Menu.Item>
            <Menu.Divider />
            <Menu.Item key="addressQuery" className="dropdown-item">
                <Link to={`/addressQuery`}>Query by Address</Link>
            </Menu.Item>
            <Menu.Item key="zipQuery" className="dropdown-item">
                <Link to={`/zipQuery`}>Query by Zipcode</Link>
            </Menu.Item>
            <Menu.Item key="func1Query" className="dropdown-item">
                <Link to={`/func1Query`}>Function 1 Query</Link>
            </Menu.Item>
            <Menu.Item key="func2Query" className="dropdown-item">
                <Link to={`/func2Query`}>Function 2 Query</Link>
            </Menu.Item>
            <Menu.Item key="func3Query" className="dropdown-item">
                <Link to={`/func3Query`}>Function 3 Query</Link>
            </Menu.Item>
        </Menu>
    );

    return (
        <Dropdown
            overlay={dropdownMenu}
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
            <a className="ant-dropdown-link">
                <img src={queryIcon} alt="query" className="query-icon" />
            </a>
        </Dropdown>
    );
}

function handleLightType({ key }) {
    if(key === "newAlleyLightIncident") {
        localStorage.requestType = 'Alley Light Out';
    } else if(key === "newStreetLightAllIncident") {
        localStorage.requestType = 'Street Lights - All/Out';
    } else if(key === "newStreetLightOneIncident") {
        localStorage.requestType = 'Street Light - 1/Out';
    }
}


export default withRouter(AppHeader);
