import React, { useState, useEffect } from 'react';
import UserService from '../service/UserService';
import { Link } from 'react-router-dom';
import './ProfilePage.css';

function ProfilePage() {
    const [profileInfo, setProfileInfo] = useState({});
    const [isAdmin, setIsAdmin] = useState(UserService.isAdmin());
    const [isAuthenticated, setIsAuthenticated] = useState(UserService.isAuthenticated());

    useEffect(() => {
        fetchProfileInfo();
    }, []);

    const fetchProfileInfo = async () => {
        try {
            const token = localStorage.getItem('token'); // Retrieve the token from localStorage
            const response = await UserService.getYourProfile(token);
            setProfileInfo(response.ourUsers);
        } catch (error) {
            console.error('Error fetching profile information:', error);
        }
    };

    const handleLogout = () => {
        UserService.logout();
        setIsAuthenticated(false);
        setIsAdmin(false);
    };

    return (
        <div className="profile-page-container">
            <h2 className="profile-heading">Profile Information</h2>
            <div className="profile-details">
                <p className="profile-detail"><strong>Name:</strong> {profileInfo.name}</p>
                <p className="profile-detail"><strong>Email:</strong> {profileInfo.email}</p>
                <p className="profile-detail"><strong>City:</strong> {profileInfo.city}</p>
            </div>
            {profileInfo.role === "ADMIN" && (
                <div className="profile-actions">
                    <Link to={`/update-user/${profileInfo.id}`} className="profile-action-button">
                        Update This Profile
                    </Link>
                </div>
            )}
            {isAdmin && (
                <div className="profile-actions">
                    <Link to="/admin/user-management" className="profile-action-button">
                        User Management
                    </Link>
                </div>
            )}
            <div className="profile-actions">
                <Link to="/" onClick={handleLogout} className="profile-action-button-logout">
                    Logout
                </Link>
            </div>
        </div>
    );
}

export default ProfilePage;
