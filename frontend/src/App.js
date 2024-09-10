import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import BackgroundSection from './components/BackgroundSection';
import FeaturedJobs from './components/FeaturedJobs';
import SearchBar from './components/SearchBar';
import CompanySpotlight from './components/CompanySpotlight';
import Footer from './components/Footer';
import Signup from './components/Signup'; // Import Signup component
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
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
                <Footer />
              </>
            }
          />
          {/* Define the Signup page route */}
          <Route path="/signup" element={<Signup />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
