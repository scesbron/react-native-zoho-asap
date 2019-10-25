#import "ZohoAsap.h"

@import ZohoDeskPortalSDK;

@implementation ZohoAsap

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(init:(NSString *)orgId appId(NSString *)appId dataCenterValue(NSString *)dataCenterValue language(NSString *)language)
{
    ZDPortalConfiguration * config = [[ZDPortalConfiguration alloc]init];
    ZDPortalConfiguration.setSDKLanguage = language;
    config.enableHelpCenter = YES;
    config.enableCommunity = YES;
    config.enableCreateTicket = YES;
    config.enableMyTicket = YES;
    ZDDataCenter.valueOf(dataCenterValue)
    [ZohoDeskPortalSDK initializeSDK:orgId appId:appId dataCenter:<#dataCenterValue#> configuration:<#config#>];
}

RCT_EXPORT_METHOD(startDeskHomeScreen)
{
    [ZohoDeskPortalSDK showLiveChatWithController:self];
    [ZohoDeskPortalSDK showHomePageWithController:self];
}

@end
