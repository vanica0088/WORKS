import React, { Component, Fragment } from 'react'
import PostInput from './PostInput'
import PostItem from './PostItem'
import './Landing.css'

export default class Landing extends Component {
    constructor(props) {
        super(props);
        this.state = {
            comallItems: []
        }
        this.submitPosts = this.submitPosts.bind(this);
        this.removePosts = this.removePosts.bind(this);
    }

    submitPosts(info) {
        this.setState({
            comallItems: [...this.state.comallItems, info]
        })
    }

    removePosts(index) {
        const newPostsList = [...this.state.comallItems]
        newPostsList.splice(index, 1)
        this.setState({
            comallItems: newPostsList
        })
    }

    render() {
        return (
            <Fragment>
                <div className="post_input">
                    <PostInput submitPosts={info => this.submitPosts(info)} />
                </div>
                <div className="post_item">
                    {
                        this.state.comallItems.map((item, index) => {
                            return (
                                <PostItem
                                    posts={item}
                                    key={item.id}
                                    removeItem={e => this.removePosts(index)}
                                />
                            )
                        })
                    }
                </div>
            </Fragment>
        )
    }
}