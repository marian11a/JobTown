import React from 'react';
import './Navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-left">
        <a href="/" className="navbar-logo">
          JobTown
        </a>
      </div>
      <div className="navbar-right">
        <a href="/signin" className="navbar-button">
          Sign In
        </a>
        <a href="/signup" className="navbar-button">
          Sign Up
        </a>
      </div>
    </nav>
  );
};

export default Navbar;
