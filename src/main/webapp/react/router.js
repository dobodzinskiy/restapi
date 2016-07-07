import { Router, Route, IndexRoute } from 'react-router';
import React from 'react';

export default (
    <Router>
        <Route path="/" component={Layout}>
            <IndexRoute component={Rooms}/>
            <Route path="order" component={Order}>
                <Route path="ready" component={OrderReady}/>
            </Route>
        </Route>
    </Router>
)
