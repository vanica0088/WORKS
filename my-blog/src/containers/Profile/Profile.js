import React, { Component } from 'react';
import { Form, Input, Button, DatePicker } from 'antd';
import './Profile.css'

class Profile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: '',
      lastName: '',
      username: '',
      email:'',
      password: '',
      dob: ''
    }
    this.handleChangeFirstname = this.handleChangeFirstname.bind(this);
    this.handleChangelastname = this.handleChangelastname.bind(this);
    this.handleChangeUsername = this.handleChangeUsername.bind(this);
    this.handleChangeEmail = this.handleChangeEmail.bind(this);
    this.handleChangePassword = this.handleChangePassword.bind(this);

  }

  handleChangeFirstname(e) {
    console.log("Changed")
    this.setState({
      firstName: e.target.value
    })
  }
  handleChangelastname(e) {
    this.setState({
      lastName: e.target.value
    })
  }
  handleChangeUsername(e) {
    this.setState({
      userName: e.target.value
    })
  }

  handleChangeEmail(e) {
    this.setState({
      email: e.target.value
    })
  }
  handleChangePassword(e) {
    this.setState({
      password: e.target.value
    })
  }
  updValue() {
  }




  render() {
    return (
      <div className="profile">
        <Form
          labelCol={{ span: 8, }}
          wrapperCol={{ span: 10, }}
          layout="horizontal"
        >
          <Form.Item label="First Name">
            <Input
              value={this.state.firstName}
              onChange={e => this.handleChangeFirstname(e)}
            />
          </Form.Item>
          <Form.Item label="Last Name">
            <Input
              value={this.state.lastName}
              onChange={e => this.handleChangelastname(e)}
            />
          </Form.Item>
          
          <Form.Item label="User Name" >
            <Input
              value={this.props.username}
              onChange={e => this.handleChangeUsername(e)}
            />
          </Form.Item>
          
          <Form.Item label="E-mail" >
            <Input
              value={this.props.email}
              onChange={e => this.handleChangeEmail(e)}
            />
          </Form.Item>

          <Form.Item label="Password">
            <Input.Password
              value={this.state.password}

              onChange={e => this.handleChangePassword(e)}
            />
          </Form.Item>
          <Form.Item label="DOB">
            <DatePicker />
          </Form.Item>
        </Form>
        <div className="profile_btn">
          <Button className="confirm" type="default" onClick={this.updValue}>CONFIRM</Button>
        </div>
      </div>
    );
  }
}


export default Profile
