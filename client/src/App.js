import React, { Component } from 'react';
import Header from '../src/Components/Header';
import Footer from '../src/Components/Footer';
import heroimg from './foodphoto.jpg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header />
        <div className="container">
          <div className="title">
              <h2>Reducing food waste for food equality</h2>
              <img class="heroimg" src={heroimg} alt="food-waste"></img>
          </div>
          <div class="subtitle">
            <p>
              Many catering events have food waste, which gets thrown away, creating food waste. In fact, the United States is the leading producer of food waste. By donating your leftover food to a non-profit organization in need of food, you will be serving your community by feeding those who are hungry.
            </p>
          </div>
          <div className="card-l">
            <h3>Hacks for Humanity</h3>
            <h6><span role="img" aria-label="Food">🥘</span> Vegetarian and Non-vegetarian</h6>
            <h6><center><span role="img" aria-label="LocationMarker">📍</span> 5 miles away</center></h6>
          </div>
          <div className="card-r">
            <h3>International Night</h3>
            <h6><span role="img" aria-label="Food">🥘</span> Meat</h6>
            <h6><center><span role="img" aria-label="LocationMarker">📍</span> 2 miles away</center></h6>
          </div>
        </div>
        <Footer />
      </div>
    );
  }
}

export default App;
