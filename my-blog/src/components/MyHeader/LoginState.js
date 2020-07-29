import React, { Component, Fragment } from 'react'
import { NavLink } from 'react-router-dom';
import { Menu, Dropdown } from 'antd';
import { DownOutlined } from '@ant-design/icons';
import './MyHeader.css'

const menu = (
    <Menu>
        <Menu.Item>
            <NavLink to="/profile">
                Profile
            </NavLink>
        </Menu.Item>
        
        <Menu.Item>
            <NavLink to="/signout" onClick={signOut}>
                Sign out
            </NavLink>
        </Menu.Item>
    </Menu>
)

function signOut() {
    global.config.userId = "";
}

export default class LoginState extends Component {
    render() {
        if (global.config.userId === '') {
            return (
                <Fragment>
                    <li><NavLink to="/signup">Sign up</NavLink></li>
                    <li><NavLink to="/signin">Sign in</NavLink></li>
                </Fragment>
            )
        } else {
            return (
                <li>
                    <Dropdown overlay={menu}>
                        <NavLink to="/profile">
                            {global.config.userName}<DownOutlined />
                        </NavLink>
                    </Dropdown>
                </li>
            )
        }
    }
}
