import React, { Component, Fragment } from 'react';
import { NavLink, withRouter } from 'react-router-dom';
import LoginState from './LoginState';
import './MyHeader.css';
import logo from './logo.ico';

class MyHeader extends Component {
    render() {
        return (
            <Fragment>
                <div className="logo">
                    <img src={logo} alt="" />
                    <div className="text">
                        <p>PUBLIC BLOG</p>
                    </div>
                </div>
                <div className="nav">
                    <ul>
                        <li><NavLink to="/">LADING</NavLink></li>
                    </ul>
                </div>
                <div className="sign">
                    <LoginState />
                </div>

            </Fragment>
        )
    }

}

export default withRouter(MyHeader);