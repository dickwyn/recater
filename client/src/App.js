import React, { Component } from 'react';
import Header from '../src/Components/Header';
import Indicator from '../src/Components/Indicator';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header />
        <Indicator />
        <footer>
          Not for display
        </footer>
      </div>
    );
  }
}

export default App;
