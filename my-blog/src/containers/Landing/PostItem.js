import React, { Component, Fragment } from 'react'
import { Comment, Avatar, Tooltip, } from 'antd'
import { DeleteOutlined } from '@ant-design/icons'

export default class PostItem extends Component {

    removeItem() {
        this.props.removeItem()
    }

    render() {
        const { userName, avatar, title, content, datetime } = this.props.posts
        return (
            <Comment
                className="post_content"
                author={<a href="/profile?id">{userName}</a>}
                avatar={
                    <Avatar
                        src={avatar}
                        alt={userName}
                    />
                }
                content={
                    <Fragment>
                        <p className="p1">
                            {title}
                        </p>
                        <p>
                            {content}
                        </p>
                    </Fragment>
                }
                datetime={
                    <Tooltip title={datetime.format('YYYY-MM-DD HH:mm:ss')}>
                        <span className="time">{datetime.fromNow()}</span>
                    </Tooltip>
                }
                actions={[
                    <span onClick={e => this.removeItem()}><DeleteOutlined />Delet</span>
                ]}
            />
        )
    }
}