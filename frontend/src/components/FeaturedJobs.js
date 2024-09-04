import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './FeaturedJobs.css';

function FeaturedJobs() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    // Fetch the jobs from the backend API
    axios.get('http://localhost:8080/api/jobs')
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
            <p><strong>Company:</strong> {job.company ? job.company.name : 'N/A'}</p>
            <p><strong>Location:</strong> {job.location}</p>
            <p><strong>Salary:</strong> ${job.salary}</p>
            <p><strong>Employment Type:</strong> {job.employmentType}</p>
            <p><strong>Description:</strong> {job.description}</p>
            <p><strong>Posted At:</strong> {new Date(job.postedAt).toLocaleDateString()}</p>
            <p><strong>Expires At:</strong> {new Date(job.expiresAt).toLocaleDateString()}</p>
            <a href={`/jobs/${job.id}`} className="btn-primary">View Job</a>
          </div>
        ))}
      </div>
    </div>
  );
}

export default FeaturedJobs;
