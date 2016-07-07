import React from 'react';

class Layout extends React.Component {
    render() {
        return (
            <div class="container">
                <h2 class="page-header">
                    Room booking.
                </h2>

                {this.props.children}

            </div>
        )
    }
}