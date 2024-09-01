import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './FeaturedJobs.css';

function FeaturedJobs() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    // Replace with your API endpoint
    axios.get('http://localhost:8080/api/featured-jobs')
      .then(response => setJobs(response.data))
      .catch(error => console.error('Error fetching jobs:', error));
  }, []);

  return (
    <div className="featured-jobs">
      <h2>Featured Jobs</h2>
      <div className="job-list">
        {jobs.map((job, index) => (
          <div key={index} className="job-card">
            <h3>{job.title}</h3>
            <p>{job.company}</p>
            <a href={job.link} className="btn-primary">View Job</a>
          </div>
        ))}
      </div>
    </div>
  );
}

export default FeaturedJobs;
