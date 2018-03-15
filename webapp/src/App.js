import React, { Component } from 'react';
import phoneLog from './callingFee.json';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  render() {
    return (
      <div className="App">
        {/* <ul>
        {
          phoneLog.map(function(phoneLog){
            return <li>{phoneLog.callingTime} - {phoneLog.callFee}</li>;
          })
        }
        </ul> */}
        <table>
          <tr>
            <th>Customer Phone Number</th>
            <th>Customer Calling Time</th>
            <th>Customer Call Fee</th>
          </tr>
         { phoneLog.map(function(phoneLog){
            return <tr><td>{phoneLog.phoneNumber}</td><td>{phoneLog.callingTime}</td><td>{phoneLog.callFee}</td></tr>;
          })}
        </table>
      </div>
    );
  }
}

export default App;
