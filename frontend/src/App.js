import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Navbar from './components/common/Navbar';
import LoginPage from './components/auth/LoginPage';
import RegistrationPage from './components/auth/RegistrationPage';
import FooterComponent from './components/common/Footer';
import UserService from './components/service/UserService';
import UpdateUser from './components/userspage/UpdateUser';
import UserManagementPage from './components/userspage/UserManagementPage';
import ProfilePage from './components/userspage/ProfilePage';
import BackgroundSection from './components/home/BackgroundSection'; // Adjust as per your structure
import SearchBar from './components/home/SearchBar';  // Adjust as per your structure
import FeaturedJobs from './components/home/FeaturedJobs';  // Adjust as per your structure
import CompanySpotlight from './components/home/CompanySpotlight';  // Adjust as per your structure
import './App.css';

function App() {
  const isAuthenticated = UserService.isAuthenticated();
  const isAdmin = UserService.adminOnly();

  return (
    <Router>
      <div className="App">
        {/* Navbar displayed on all pages */}
        <Navbar />

        <Routes>
          {/* Define the Home page route */}
          <Route
            path="/"
            element={
              <>
                <BackgroundSection />
                <SearchBar />
                <FeaturedJobs />
                <CompanySpotlight />
                <FooterComponent />
              </>
            }
          />

          {/* Define Signin and Signup routes */}
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegistrationPage />} />

          {/* Profile page route (accessible only if authenticated) */}
          {isAuthenticated && <Route path="/profile" element={<ProfilePage />} />}

          {/* Admin routes (accessible only if the user is an admin) */}
          {isAdmin && (
            <>
              <Route path="/register" element={<RegistrationPage />} />
              <Route path="/admin/user-management" element={<UserManagementPage />} />
              <Route path="/update-user/:userId" element={<UpdateUser />} />
            </>
          )}

          {/* Redirect any unknown routes to the login page */}
          <Route path="*" element={<Navigate to="/login" />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
