import React from 'react';
import $ from 'jquery';
import { hashHistory } from 'react-router';

class OrderReady extends React.Component {
    render() {
        var { order } = this.props.roomState;
        return(
            <div>
                <h2>Order #{order.id} was submitted. Our manager will contact you soon, thanks!</h2>
            </div>
        )
    }
}
export default OrderReady;