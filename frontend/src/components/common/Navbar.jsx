// Navbar.js
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import UserService from '../service/UserService';
import './Navbar.css';

function Navbar() {
    const [isAuthenticated, setIsAuthenticated] = useState(UserService.isAuthenticated());
    const [isAdmin, setIsAdmin] = useState(UserService.isAdmin());

    useEffect(() => {
        const checkAuthStatus = () => {
            setIsAuthenticated(UserService.isAuthenticated());
            setIsAdmin(UserService.isAdmin());
        };

        checkAuthStatus();
        // Optionally set an interval or listen to some event if you expect changes dynamically
        const interval = setInterval(checkAuthStatus, 300); // Polling every second

        return () => clearInterval(interval); // Cleanup on unmount
    }, []);

    const handleLogout = () => {
        UserService.logout();
        setIsAuthenticated(false);
        setIsAdmin(false);
    };

    return (
        <nav className="navbar">
            <div className="navbar-left">
                <Link to="/" className="navbar-logo">
                    JobTown
                </Link>
            </div>

            <div className="navbar-right">
                {!isAuthenticated && (
                    <>
                        <Link to="/login" className="navbar-button">
                            Sign In
                        </Link>
                        <Link to="/register" className="navbar-button">
                            Sign Up
                        </Link>
                    </>
                )}
                {isAuthenticated && (
                    <>
                        <Link to="/profile" className="navbar-button">
                            Profile
                        </Link>
                    </>
                )}
            </div>
        </nav>
    );
}

export default Navbar;
