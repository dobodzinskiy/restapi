import React from 'react';
import $ from 'jquery';
import { hashHistory } from 'react-router';

class OrderReady extends React.Component {
    render() {
        var { order } = this.props.roomState;
        return (
            <div>
                <div class="well">
                    <h2>Order #{order.id} was submitted. Our manager will contact you soon, thanks!</h2>
                </div>
                <h3>Your order:</h3>
                <table class="table table-hover">
                    <tbody>
                    <tr>
                        <td>Number</td>
                        <td>{order.number}</td>
                    </tr>
                    <tr>
                        <td>Hotel</td>
                        <td>{order.hotelName}</td>
                    </tr>
                    <tr>
                        <td>Client</td>
                        <td>{order.clientName + ' ' + order.clientLastName}</td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>{order.clientPhone}</td>
                    </tr>
                    <tr>
                        <td>Period</td>
                        <td>{'From ' + order.start + ' to ' + order.end}</td>
                    </tr>
                    </tbody>
                </table>
                <hr/>
                <a href="#/" class="btn btn-primary">Home</a>
            </div>
        )
    }
}
export default OrderReady;