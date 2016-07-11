import React from 'react';
import $ from 'jquery';
import { hashHistory } from 'react-router';

class Order extends React.Component {
    componentDidMount() {
        this.props.getRoom(this.props.params.id);
    }

    order() {
        var { room } = this.props.roomState;
        var order = {
            hotelName: room.hotelName,
            hotelId: room.hotelId,
            number: room.number,
            roomId: room.id,
            clientName: $("#name").val(),
            clientLastName: $("#lastName").val(),
            clientPhone: $("#phone").val(),
            start: $("#start").val(),
            end: $("#end").val()
        };
        this.props.order(order);
        hashHistory.replace("/order/ready");
    }

    render() {
        var { room } = this.props.roomState;
        if (this.props.children) {
            return(
                <div>
                    {this.props.children}
                </div>
            )

        }
        return (
            <div>
                <h2>Booking a room # {room.number}</h2>
                <form role="form" onSubmit={(e) => { e.preventDefault(); this.order();}}>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" required/>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last name:</label>
                            <input type="text" class="form-control" id="lastName" required/>
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input type="tel" class="form-control" id="phone" required/>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="start">Start:</label>
                            <input type="date" class="form-control" id="start" required/>
                        </div>
                        <div class="form-group">
                            <label for="end">End:</label>
                            <input type="date" class="form-control" id="end" required/>
                        </div>
                    </div>
                    <div class="col-sm-12 text-center">
                        <button type="submit" class="btn btn-primary">Order</button>
                    </div>
                </form>
            </div>
        )
    }
}

export default Order;