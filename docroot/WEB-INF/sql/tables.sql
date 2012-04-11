create table Onddo_Picking (
	pickingId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	type_ VARCHAR(75) null,
	lat DOUBLE,
	lng DOUBLE,
	moonPhase VARCHAR(75) null,
	weather VARCHAR(75) null,
	temperature DOUBLE,
	humidity DOUBLE,
	imgId LONG,
	imgName VARCHAR(75) null
);

create table Onddo_UserSetting (
	userSettingId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	visibilityToFriends VARCHAR(75) null,
	visibilityToOthers VARCHAR(75) null,
	tweetPicking BOOLEAN
);