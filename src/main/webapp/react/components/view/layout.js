import React from 'react';

class Layout extends React.Component {
    render() {
        return (
            <div class="container">
                <div class="col-sm-12 text-center header main">
                    <h2>Room booking</h2>
                </div>
                <div class="col-sm-12 main">

                    {this.props.children}

                </div>
            </div>
        )
    }
}

export default Layout;