import React, { Component } from 'react';
import { Progress } from 'reactstrap';
import './style.css';

export default class Indicator extends Component {
  render() {
    return (
      <div>
        <div className="container">
            <div className="time">
                <h5>Time</h5>
                <Progress color="warning" value={75}>75% done</Progress>
            </div>
            <div className="temperature">
                <h5>Temperature</h5>
                <div className="card">
                    70
                </div>
            </div>
            <div className="heartrate">
                <h5>Heart Rate</h5>
                <div className="card">
                    150bpm
                </div>
            </div>
            <div className="humidity">
                <h5>Humidity</h5>
                <div className="card">
                    200ml/g
                </div>
            </div>
            <div className="sound">
                <h5>Sound</h5>

            </div>
            <div className="acceleration">
                <h5>Acceleration</h5>
                <div className="card">
                    82
                </div>              
            </div>
        </div>
      </div>
    );
  }
}