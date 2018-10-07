import React from 'react';
import { render }from 'react-dom';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Community from './Components/Community';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Switch, BrowserRouter, Route } from 'react-router-dom';


render(
    <BrowserRouter>
      <Switch>
        <Route exact path='/' component={App}/>
        <Route path='/Community' component={Community} />
      </Switch>
    </BrowserRouter>,
    document.getElementById('root'));

