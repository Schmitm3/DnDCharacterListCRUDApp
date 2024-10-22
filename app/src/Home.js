import React from 'react';
import './App.css';
import AppNavbar from './NavBar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

const Home = () => {
  return (
    <div>
      <AppNavbar/>
      <Container fluid>
        <Button color="link"><Link to="/characters">Manage Characters</Link></Button>
      </Container>
    </div>
  );
}

export default Home;