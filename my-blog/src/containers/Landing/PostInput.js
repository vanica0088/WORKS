import React, { Component, Fragment } from 'react'
import { Form, Input, Button } from 'antd'
import moment from 'moment'
import './Landing.css'

const layout = {
    labelCol: { span: 5 },
    wrapperCol: { span: 15 },
};

export default class PostInput extends Component {
    constructor(props) {
        super(props);
        this.state = {
            title: '',
            content: ''
        }
        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeContent = this.handleChangeContent.bind(this);
        this.addPosts = this.addPosts.bind(this)
    }

    handleChangeTitle(e) {
        this.setState({
            title: e.target.value
        })
    }
    handleChangeContent(e) {
        this.setState({
            content: e.target.value
        })
    }

    addPosts() {
        const postsInfo = {
            id: 'moment().valueOf()',
            userId: global.config.userId,
            avatar: global.config.avatar,
            userName: global.config.userName,
            datetime: moment(),
            title: this.state.title,
            content: this.state.content
        }

        this.props.submitPosts(postsInfo)
        this.setState({
            title: '',
            content: ''
        })
    }

    render() {
        if (global.config.userId === '') {
            return <div></div>
        } else {
            return (
                <Fragment>
                    <Form {...layout}>
                        <Form.Item label="Title" rules={[{ required: true, message: 'Please input title!' }]}>
                            <Input
                                value={this.state.title}
                                onChange={this.handleChangeTitle}
                            />
                        </Form.Item>
                        <Form.Item label="Content" rules={[{ required: true, message: 'Please input content!' }]}>
                            <Input.TextArea
                                placeholder="Write down something here~"
                                rows={10}
                                cols={90}
                                value={this.state.content}
                                onChange={this.handleChangeContent}
                            />
                        </Form.Item>
                    </Form>
                    <div className="post_btn">
                        <Button className="post" type="default" onClick={this.addPosts}>POST</Button>
                    </div>
                </Fragment>
            )
        }
    }
}
