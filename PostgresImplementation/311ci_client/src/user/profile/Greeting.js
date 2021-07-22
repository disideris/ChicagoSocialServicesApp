import React, { Component } from 'react';
import './Greeting.css';


class Greeting extends Component {

    render() {

        return (
            <div className="greeting">
                <div className="greeting-container">
                    <span>Welcome to 311CI Service</span>
                </div>
            </div>
        );
    }
}

export default Greeting;