import React, { useState } from 'react';
import axios from 'axios';
import './Signin.css';  // Assuming similar styling with adjustments

const Signin = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const [error, setError] = useState('');

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    try {
      // POST request to the backend
      const response = await axios.post('http://localhost:8080/api/signin', {
        email: formData.email,
        password: formData.password,
      });

      console.log('User signed in:', response.data);
      // Optionally redirect the user after signin
      window.location.href = '/'; // Redirect to home or dashboard after sign in
    } catch (err) {
      console.error('Signin error:', err);
      setError('An error occurred during signin. Please try again.');
    }
  };

  return (
    <div className="body-signin">
      <div className="signin-container">
        <h2>Sign In</h2>
        {error && <p className="error-message">{error}</p>}
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              name="email"
              id="email"
              value={formData.email}
              onChange={handleChange}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              type="password"
              name="password"
              id="password"
              value={formData.password}
              onChange={handleChange}
              required
            />
          </div>
          <button type="submit" className="btn-primary-2">Sign In</button>
        </form>
      </div>
    </div>
  );
};

export default Signin;
