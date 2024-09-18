import React from 'react';
import { Link } from 'react-router-dom';
import UserService from '../service/UserService';
import './Navbar.css';

function Navbar() {
    const isAuthenticated = UserService.isAuthenticated();
    const isAdmin = UserService.isAdmin();

    const handleLogout = () => {
        const confirmDelete = window.confirm('Are you sure you want to logout this user?');
        if (confirmDelete) {
            UserService.logout();
        }
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
                        <Link to="/" onClick={handleLogout} className="navbar-button">
                            Logout
                        </Link>
                    </>
                )}
                {isAdmin && (
                    <Link to="/admin/user-management" className="navbar-button">
                        User Management
                    </Link>
                )}
            </div>
        </nav>
    );
}

export default Navbar;
