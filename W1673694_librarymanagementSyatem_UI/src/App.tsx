import * as React from 'react';
import { 
  BrowserRouter as Router
} from 'react-router-dom';
import './App.css';
import Home from './components/dashboard/Dashboard';

class App extends React.Component {
  public render() {
    return (
      <Router>
        <Home />
      </Router>
    );
  }
}

export default App;
