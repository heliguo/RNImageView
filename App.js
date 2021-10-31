import React, {Component} from 'react';
import {Button, Image, NativeModules, ScrollView, Text, View} from 'react-native';
import RCTCustomImageView from './CustomImageView'

class App extends Component {

    loadNativeImageView = () => {
        NativeModules['CustomImageView'].show("https://reactnative.dev/docs/assets/p_cat2.png")
    };

    render() {
        return (
            <ScrollView>
                <View>
                    <Text>RN加载网络图片</Text>
                    <Image
                        source={{
                            uri: 'https://reactnative.dev/docs/assets/p_cat2.png',
                        }}
                        style={{width: 200, height: 200}}
                    />
                </View>

                <Button
                    onPress={this.loadNativeImageView}
                    title="点击使用Android组件加载网络图片"
                    color="#ff0000"
                />
                <RCTCustomImageView
                    ref="cusIv"
                    style={{width: 300, height: 300}}
                />
            </ScrollView>
        );
    }
}

export default App;