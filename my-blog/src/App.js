import React, { Component }from 'react';
import { Switch, Route, BrowserRouter } from 'react-router-dom';
import { Layout } from 'antd';
import MyHeader from './components/MyHeader/MyHeader';
import Profile from './containers/Profile/Profile';
import Landing from './containers/Landing/Landing';
import './App.css';

const { Header, Footer, Content } = Layout;

global.config = {
  userId: '1',
  userName: 'Vanica',
  avatar: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1594968202430&di=0f52c1aecb33d5f8650071f2b485316c&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201503%2F15%2F20150315182428_eci5K.png',
}

class App extends Component {
  render() {
    return (
        <BrowserRouter>
          <Layout>
            <Header className="header">
              <MyHeader />
            </Header>
            <Content className="content">
              <Switch>
                {/* <Route exac path='/signin' component={Login} />
                <Route exac path='/signup' component={Login} /> */}
                <Route exac path='/profile' component={Profile} />
                <Route exac path='/' component={Landing} />
              </Switch>
            </Content>
            <Footer className="footer">
              <p>&copy; TeamPoject  2020</p>
            </Footer>
          </Layout>
        </BrowserRouter>
      
    )
  }
}

export default App;
