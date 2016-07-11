import { Router, Route, IndexRoute } from 'react-router';
import React from 'react';

import Layout from './components/view/layout';
import Rooms from './components/container/roomsContainer';
import Order from './components/container/orderContainer';
import OrderReady from './components/container/orderReadyContainer';

export default (
    <Router>
        <Route path="/" component={Layout}>
            <IndexRoute component={Rooms}/>
            <Route path="order/:id" component={Order}>
                <Route path="ready" component={OrderReady}/>
            </Route>
        </Route>
    </Router>
)