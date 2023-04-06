// Code generated by mockery v1.0.0. DO NOT EDIT.

package scanner

import (
	"context"

	fanaltypes "github.com/aquasecurity/trivy/pkg/fanal/types"
	mock "github.com/stretchr/testify/mock"

	types "github.com/aquasecurity/trivy/pkg/types"
)

// MockDriver is an autogenerated mock type for the Driver type
type MockDriver struct {
	mock.Mock
}

type DriverScanArgs struct {
	Ctx              context.Context
	CtxAnything      bool
	Target           string
	TargetAnything   bool
	ImageID          string
	ImageIDAnything  bool
	LayerIDs         []string
	LayerIDsAnything bool
	Options          types.ScanOptions
	OptionsAnything  bool
}

type DriverScanReturns struct {
	Results types.Results
	OsFound *fanaltypes.OS
	Err     error
}

type DriverScanExpectation struct {
	Args    DriverScanArgs
	Returns DriverScanReturns
}

func (_m *MockDriver) ApplyScanExpectation(e DriverScanExpectation) {
	var args []interface{}
	if e.Args.CtxAnything {
		args = append(args, mock.Anything)
	} else {
		args = append(args, e.Args.Ctx)
	}
	if e.Args.TargetAnything {
		args = append(args, mock.Anything)
	} else {
		args = append(args, e.Args.Target)
	}
	if e.Args.ImageIDAnything {
		args = append(args, mock.Anything)
	} else {
		args = append(args, e.Args.ImageID)
	}
	if e.Args.LayerIDsAnything {
		args = append(args, mock.Anything)
	} else {
		args = append(args, e.Args.LayerIDs)
	}
	if e.Args.OptionsAnything {
		args = append(args, mock.Anything)
	} else {
		args = append(args, e.Args.Options)
	}
	_m.On("Scan", args...).Return(e.Returns.Results, e.Returns.OsFound, e.Returns.Err)
}

func (_m *MockDriver) ApplyScanExpectations(expectations []DriverScanExpectation) {
	for _, e := range expectations {
		_m.ApplyScanExpectation(e)
	}
}

// Scan provides a mock function with given fields: ctx, target, imageID, layerIDs, options
func (_m *MockDriver) Scan(ctx context.Context, target string, artifactKey string, blobKeys []string, options types.ScanOptions) (types.Results, *fanaltypes.OS, error) {
	ret := _m.Called(ctx, target, artifactKey, blobKeys, options)

	var r0 types.Results
	if rf, ok := ret.Get(0).(func(context.Context, string, string, []string, types.ScanOptions) types.Results); ok {
		r0 = rf(ctx, target, artifactKey, blobKeys, options)
	} else {
		if ret.Get(0) != nil {
			r0 = ret.Get(0).(types.Results)
		}
	}

	var r1 *fanaltypes.OS
	if rf, ok := ret.Get(1).(func(context.Context, string, string, []string, types.ScanOptions) *fanaltypes.OS); ok {
		r1 = rf(ctx, target, artifactKey, blobKeys, options)
	} else {
		if ret.Get(1) != nil {
			r1 = ret.Get(1).(*fanaltypes.OS)
		}
	}

	var r2 error
	if rf, ok := ret.Get(2).(func(context.Context, string, string, []string, types.ScanOptions) error); ok {
		r2 = rf(ctx, target, artifactKey, blobKeys, options)
	} else {
		r2 = ret.Error(2)
	}

	return r0, r1, r2
}
