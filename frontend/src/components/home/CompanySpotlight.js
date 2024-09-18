import React from 'react';
import './CompanySpotlight.css';

function CompanySpotlight() {
  return (
    <div className="company-spotlight">
      <h2>Company Spotlight</h2>
      <div className="company-list">
        <div className="company-card">
          <h3>Company A</h3>
          <p>Innovating the tech world.</p>
        </div>
        <div className="company-card">
          <h3>Company B</h3>
          <p>Leading the industry with excellence.</p>
        </div>
        {/* Add more companies as needed */}
      </div>
    </div>
  );
}

export default CompanySpotlight;
