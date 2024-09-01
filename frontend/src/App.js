import React from 'react';
import HeroSection from './components/BackgroundSection';
import FeaturedJobs from './components/FeaturedJobs';
import SearchBar from './components/SearchBar';
import CompanySpotlight from './components/CompanySpotlight';
import Footer from './components/Footer';
import './App.css';

function App() {
  return (
    <div className="App">
      <HeroSection />
      <SearchBar />
      <FeaturedJobs />
      <CompanySpotlight />
      <Footer />
    </div>
  );
}

export default App;
