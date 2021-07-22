import React, { Component } from 'react';
import './App.css';
import {
  Route,
  withRouter,
  Switch
} from 'react-router-dom';

import { getCurrentUser } from '../util/APIUtils';
import { ACCESS_TOKEN } from '../constants';

import QueryList from '../query/QueryList'
import Login from '../user/login/Login';
import Signup from '../user/signup/Signup';
import Profile from '../user/profile/Profile';
import Greeting from '../user/profile/Greeting';
import AppHeader from '../common/AppHeader';
import NotFound from '../common/NotFound';
import LoadingIndicator from '../common/LoadingIndicator';
import PrivateRoute from '../common/PrivateRoute';

import { Layout, notification } from 'antd';
import NewAddressQuery from "../query/NewAddressQuery";
import NewZipQuery from "../query/NewZipQuery";
import NewFunc1Query from "../query/NewFunc1Query";
import NewFunc2Query from "../query/NewFunc2Query";
import NewFunc3Query from "../query/NewFunc3Query";

import NewVehicleIncident from "../query/NewVehicleIncident";
import NewGraffitiIncident from "../query/NewGraffitiIncident";
import NewGarbageCartIncident from "../query/NewGarbageCartIncident";
import NewPotholeIncident from "../query/NewPotholeIncident";
import NewRodentIncident from "../query/NewRodentIncident";
import NewSanitationIncident from "../query/NewSanitationIncident";
import NewTreeDebrisIncident from "../query/NewTreeDebrisIncident";
import NewTreeTrimsIncident from "../query/NewTreeTrimsIncident";
import NewGenericIncident from "../query/NewGenericIncident";
const { Content } = Layout;

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      currentUser: null,
      isAuthenticated: false,
      isLoading: false
    }
    this.handleLogout = this.handleLogout.bind(this);
    this.loadCurrentUser = this.loadCurrentUser.bind(this);
    this.handleLogin = this.handleLogin.bind(this);

    notification.config({
      placement: 'topRight',
      top: 70,
      duration: 3,
    });
  }

  loadCurrentUser() {
    this.setState({
      isLoading: true
    });
    getCurrentUser()
    .then(response => {
      this.setState({
        currentUser: response,
        isAuthenticated: true,
        isLoading: false
      });
    }).catch(error => {
      this.setState({
        isLoading: false
      });
    });
  }

  componentDidMount() {
    this.loadCurrentUser();
  }

  handleLogout(redirectTo="/", notificationType="success", description="You're successfully logged out.") {
    localStorage.removeItem(ACCESS_TOKEN);
    localStorage.clear();

    this.setState({
      currentUser: null,
      isAuthenticated: false
    });

    this.props.history.push(redirectTo);

    notification[notificationType]({
      message: '311CI Service',
      description: description,
    });
  }

  handleLogin() {
    notification.success({
      message: '311CI Service',
      description: "You're successfully logged in.",
    });
    this.loadCurrentUser();
    this.props.history.push("/");
  }

  render() {
    if(this.state.isLoading) {
      return <LoadingIndicator />
    }
    return (
        <Layout className="app-container">
          <AppHeader isAuthenticated={this.state.isAuthenticated}
            currentUser={this.state.currentUser}
            onLogout={this.handleLogout} />

          <Content className="app-content">
            <div className="container">
              <Switch>
                <Route exact path="/"
                  render={(props) => <Greeting isAuthenticated={this.state.isAuthenticated}
                      currentUser={this.state.currentUser}  {...props}  />}>
                </Route>
                <Route exact path="/addressQuery"
                  render={(props) => <NewAddressQuery isAuthenticated={this.state.isAuthenticated}
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/zipQuery"
                  render={(props) => <NewZipQuery isAuthenticated={this.state.isAuthenticated}
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/func1Query"
                  render={(props) => <NewFunc1Query isAuthenticated={this.state.isAuthenticated}
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/func2Query"
                  render={(props) => <NewFunc2Query isAuthenticated={this.state.isAuthenticated}
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/func3Query"
                  render={(props) => <NewFunc3Query isAuthenticated={this.state.isAuthenticated}
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newGraffitiIncident"
                    render={(props) => <NewGraffitiIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newGarbageCartIncident"
                    render={(props) => <NewGarbageCartIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newPotholeIncident"
                    render={(props) => <NewPotholeIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newRodentIncident"
                    render={(props) => <NewRodentIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newSanitationIncident"
                    render={(props) => <NewSanitationIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newTreeDebrisIncident"
                    render={(props) => <NewTreeDebrisIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newTreeTrimsIncident"
                    render={(props) => <NewTreeTrimsIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newVehicleIncident"
                    render={(props) => <NewVehicleIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route exact path="/newGenericIncident"
                    render={(props) => <NewGenericIncident isAuthenticated={this.state.isAuthenticated}
                        currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route path="/login"
                  render={(props) => <Login onLogin={this.handleLogin} {...props} />}></Route>
                <Route path="/signup" component={Signup}></Route>
                <Route path="/users/:username"
                  render={(props) => <Profile isAuthenticated={this.state.isAuthenticated} currentUser={this.state.currentUser} {...props}  />}>
                </Route>
                <Route authenticated={this.state.isAuthenticated} path="/results" component={QueryList} handleLogout={this.handleLogout}></Route>
                <PrivateRoute authenticated={this.state.isAuthenticated} path="/incident/new" component={NewVehicleIncident} handleLogout={this.handleLogout}></PrivateRoute>
                <Route component={NotFound}></Route>
              </Switch>
            </div>
          </Content>
        </Layout>
    );
  }
}

export default withRouter(App);
