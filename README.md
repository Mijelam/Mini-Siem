# Mini SIEM - A Live Security Event Factory

Welcome to the Mini SIEM! This little project is a non-stop factory for fake security alerts. Using the power of Spring Boot, it generates a constant stream of log events and throws them onto a dashboard for you to watch. No real hackers, just pure simulation fun.

## Features

**Real-Time Event Generation**: A background process continuously creates new, randomized log events every 2 seconds.

**Categorized Events**: Events are randomly assigned a source (`Firewall`, `Web Server`, etc.) and a severity level (`INFO`, `WARNING`, `CRITICAL`).

**Web Dashboard**: A clean web interface to visualize the most recent events as they are generated.

**Live Statistics**: The dashboard displays a running count of events categorized by severity level.

**Zero-Configuration Database**: Uses an in-memory H2 database, requiring no external database setup.

## How It Works

1.  **Launch**: The Spring Boot application starts.
2.  **Activate Generator**: A one-time visit to the `/events/generate` endpoint kicks off a background thread that generates and saves log events.
3.  **View Dashboard**: Navigate to the `/dashboard` endpoint to see a live view of the 10 most recent events and a statistical summary.

## What's Next? The Real Fun Begins!

This is just the initial phase of the project. Right now, our Mini SIEM is just making up its own stories.

The next big step is to stop the simulation and feed it a huge dataset of *real* logs. The master plan is to build a smart correlation engine that can spot actual trouble (like a hundred failed logins in under 30 seconds) and then scream **"WARNING"** on the dashboard.
