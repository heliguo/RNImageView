// CustomImageView.js

import PropTypes from 'prop-types';
import {requireNativeComponent, View} from 'react-native';

const RCTCustomImageView = requireNativeComponent('CustomImageView', {
    propTypes: {
        url: PropTypes.string,
        ...View.propTypes,
    }
});
module.exports = RCTCustomImageView;

