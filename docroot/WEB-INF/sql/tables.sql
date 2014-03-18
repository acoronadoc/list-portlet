create table Lostsys_TaskItem (
	id_ LONG not null primary key,
	list LONG,
	label VARCHAR(75) null,
	weight INTEGER,
	status INTEGER,
	description STRING null
);

create table Lostsys_TaskItemComment (
	id_ LONG not null primary key,
	item LONG,
	userid LONG,
	description STRING null
);

create table Lostsys_TaskList (
	id_ LONG not null primary key,
	portlet VARCHAR(75) null,
	description STRING null,
	weight INTEGER,
	ratings INTEGER,
	comments INTEGER
);